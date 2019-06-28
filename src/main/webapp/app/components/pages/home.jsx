import React from 'react';
import Questions from '../items/questions';
import {t} from "localizify";

var createReactClass = require('create-react-class');
var HomePage = createReactClass({
  render() {
    return (
      <div>
          <h1>{t('projectName')}</h1>
          <Questions fetched="false" />
      </div>
    );
  }
});

export default HomePage;