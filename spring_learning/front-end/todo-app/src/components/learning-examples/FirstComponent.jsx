// First component and second components are created using functions, so they are called function components
// React component names usually start with a upper case letter
// Function components have parentheses
export default function FirstComponent() {
    return (
      <div className='FirstComponent'>First Component loaded from module</div>
    );
  }

  // Note: only one function can have default export
export function FifthComponent() {
    return (
      <div className='FifthComponent'>Fifth Component loaded from module</div>
    );
  }