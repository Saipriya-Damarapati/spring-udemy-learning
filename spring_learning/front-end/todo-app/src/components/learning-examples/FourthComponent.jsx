import { Component } from 'react'; // import Component from react package

// Only one top level tag is allowed
// -> cannot return multiple top-level JSX tags
// -> wrap into a shared parent if we need to return multiple top-level JSX tags
// -> <div>...</div> or <>...</> (empty wrapper)
export default class FourthComponent extends Component {
    render() {
      return (
        <div>
          <div className='FourthComponent'>Fourth Component</div>
          <div className='FourthComponent'>Fourth Component</div>
        </div>
      );
    }
  }