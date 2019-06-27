import React from 'react';
import $ from 'jquery';
import { Link } from 'react-router';
var createReactClass = require('create-react-class');
const Loader = createReactClass({
  render() {
    const { isActive } = this.props.isActive;

    return (
      <div className="loader">
        <div className="line-scale">
          <div></div>
          <div></div>
          <div></div>
          <div></div>
          <div></div>
        </div>
      </div>
      
    );
  }
});

export default Loader;