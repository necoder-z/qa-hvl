import React from 'react';
import { t } from 'localizify';
var createReactClass = require('create-react-class');
var Footer = createReactClass({
  render() {
    return (
      <footer className="footer" id="footer">
        <div className="copyright">
            {t('projectName')} | <span className="js-now-year">2019</span>
        </div>
      </footer>
    );
  }
});

export default Footer;