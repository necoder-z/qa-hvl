import React from 'react';
import Questions from '../items/questions';

class HomePage extends React.Component {
  render() {
    return (
      <div>
        <Questions fetched="false" />
      </div>
    );
  }
}

export default HomePage;