import React from 'react';
import auth from '../../auth';
import { t } from 'localizify';

class LogoutPage extends React.Component {
  componentDidMount() {
    auth.logout()
  }

  render() {
    return (
      <p>{t('You logout succesfully')}</p>
    );
  }
}

export default LogoutPage;