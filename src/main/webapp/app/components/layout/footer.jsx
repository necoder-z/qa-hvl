import React from 'react';
import { t } from 'localizify';

var Footer = React.createClass({
  render() {
    return (
      <footer className="footer" id="footer">
        <div className="copyright">
          HVL-QA | <span className="js-now-year">2019</span>
        </div>
      </footer>
    );
  }
});

export default Footer;