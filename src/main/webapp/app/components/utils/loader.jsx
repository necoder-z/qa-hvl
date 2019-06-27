import React from 'react';
import $ from 'jquery';
import { Link } from 'react-router';

class Loader extends React.Component {
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
}

export default Loader;