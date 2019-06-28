import React from 'react';
import Loader from '../utils/loader';
import TagService from '../../services/tag';
import { t } from 'localizify';

import { Link } from 'react-router';
import { Button, Card } from 'semantic-ui-react'

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
                  <Card.Group>
                  <Card>
                      <Card.Content>
                          <Card.Header>{item.name}</Card.Header>
                          <Card.Meta>x{item.popular}</Card.Meta>
                      </Card.Content>
                      <Card.Content extra>
                          <div className='ui two buttons'>
                              <Button as={Link} to={`/questions/tagged/${item.name}`}  basic color='green'>
                                  Go Tag
                              </Button>
                          </div>
                      </Card.Content>
                  </Card>
                  </Card.Group>
              </div> 
            )}
              
        </div>
      </div>
    );
  }
});
//item.popular
//item.name

export default TagsPage;
