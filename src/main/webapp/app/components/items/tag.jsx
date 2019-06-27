import React from 'react';
import $ from 'jquery';
import { Link } from 'react-router';
import { t } from 'localizify';

var createReactClass = require('create-react-class');
const Tag = createReactClass({
  render() {
    const { name } = this.props.data;  

    return (
      <Link to={`/questions/tagged/${name}`}
        className="post-tag" 
        title={t('Show question with tag «{name}»', { name })}
        rel="tag">
        {name}
      </Link>
    );
  }
});

export default Tag;