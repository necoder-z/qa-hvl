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
            <ul id="menu" className="menu">
              <li className="li logo">
                <Link to="/" className="black south" activeClassName="active" title="Q/A HVL">
                  <strong><i className="fa fa-bug" aria-hidden="true"></i> Q/A HVL
                  </strong>
                </Link>
              </li>
              <li className="li"><Link to="/add" activeClassName="active"><u>{t('Add')}</u></Link></li>
              <li className="li"><Link to="/tags" activeClassName="active"><u>{t('Tags')}</u></Link></li>
              <li className="li"><Link to="/dashboard" activeClassName="active"><u>{t('Profile')}</u></Link></li>
              <li className="li right"><LanguageSwitcher /></li>
              <li title={"You are " + (this.props.loggedIn ? '' : 'not') + " logged in."} className="li right">
                {this.props.loggedIn ? (

                  <span> {t('Hi')}, <b>{localStorage.name}</b> <Link to="/logout"><u>{t('Logout')}</u></Link> </span>

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