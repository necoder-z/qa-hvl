import React from 'react';
import Questions from '../items/questions';

var createReactClass = require('create-react-class');
var HomePage = createReactClass({
  render() {
    return (
      <div>
        <Questions fetched="false" />
      </div>
    );
  }
});

export default HomePage;