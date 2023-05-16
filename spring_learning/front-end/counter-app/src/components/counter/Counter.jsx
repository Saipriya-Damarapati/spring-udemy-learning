import { useState } from 'react';
import CounterButton from './CounterButton';
import './Counter.css';

export default function Counter() {
    
    const [count, setCount] = useState(0)

    function incrementCounterInParent(by) {
        setCount (count + by)
    }
    
    function decrementCounterInParent(by) {
        setCount (count - by)
    }

    function reset() {
        setCount(0)
    }

    return (
        <div>
            <span className="totalCount">{count}</span>
            <CounterButton by={1} 
                incrementMethod={incrementCounterInParent} 
                decrementMethod={decrementCounterInParent}/>

            <CounterButton by={2} 
                incrementMethod={incrementCounterInParent} 
                decrementMethod={decrementCounterInParent}/>

            <CounterButton by={5} 
                incrementMethod={incrementCounterInParent} 
                decrementMethod={decrementCounterInParent}/>

            <button className="resetButton" onClick={reset}>Reset</button>
        </div>
    );
}