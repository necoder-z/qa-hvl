import React from 'react';
import auth from '../../auth';
import { t } from 'localizify';
var createReactClass = require('create-react-class');
const LogoutPage = createReactClass({
  componentDidMount() {
    auth.logout()
  },

  render() {
    return (
      <p>{t('You logout succesfully')}</p>
    );
  }
});

export default LogoutPage;