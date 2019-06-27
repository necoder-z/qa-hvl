import React from 'react';
import Loader from '../utils/loader';
import TagService from '../../services/tag';
import { t } from 'localizify';

import { Link } from 'react-router';

var createReactClass = require('create-react-class');
const TagsPage = createReactClass({
  getInitialState() {
    return {
      data: [],
      loading: true
    };
  },
  componentDidMount() {
    const tag = this.props.tag || false;
    const service = new TagService();

     service.get().then(data => {
       this.setState({ data, loading: false });
     });     

  },
  render() {
    if (this.state.loading) {
      return ( <Loader isActive="true" /> );
    }

    const { data } = this.state;
    console.log(data);

    return (
      <div>
        <h1>{t('Tags')}</h1>

        <div className="tags">
            {data.map((item, index) =>
              <div key={index} style={{float: 'none'}}>
                <Link to ={`/questions/tagged/${item.name}`} className="post-tag" title={t('how questions by tag «{tag}»', { tag: item.name })}>{item.name}</Link>
                <span style={{paddingRight: '6px', color: '#777', fontSize: '11px'}}>x {item.popular}</span>
              </div> 
            )}
              
        </div>
      </div>
    );
  }
});

export default TagsPage;
