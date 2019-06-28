import React from 'react';
import { Link } from 'react-router';
import { t } from 'localizify';

import LanguageSwitcher from '../utils/language-switcher';
var createReactClass = require('create-react-class');
var Header = createReactClass({
  render() {
    return (
      <header id="header">
        <div className="header-wrap">
          <div className="header">
            <ul id="menu" className="menu" style={{fontSize:'14px'}}>
              <li className="li logo">
                <Link to="/" className="black south" activeClassName="active" title="Q/A HVL">
                  <strong><i className="fa fa-home" aria-hidden="true"></i> {t('projectName')}
                  </strong>
                </Link>
              </li>
              <li className="li"><Link to="/add" activeClassName="active"><u>{t('Add')}</u></Link></li>
              <li className="li"><Link to="/tags" activeClassName="active"><u>{t('Tags')}</u></Link></li>
              <li className="li right"><LanguageSwitcher /></li>
              <li title={"You are " + (this.props.loggedIn ? '' : 'not') + " logged in."} className="li right">
                {this.props.loggedIn ? (

                  <span> {t('Hi')}, <Link to="/dashboard" activeClassName="active"><b>{localStorage.name}</b></Link> <Link to="/logout"><u>{t('Logout')}</u></Link> </span>

                ) : (
                  <span>
                    <Link to="/login" activeClassName="active">{t('Login')}</Link>
                    <Link to="/signup" activeClassName="active">{t('Sign up')}</Link>
                  </span>
                )}
              </li>
            </ul>
          </div>
        </div>
      </header>
    );
  }
});

export default Header;