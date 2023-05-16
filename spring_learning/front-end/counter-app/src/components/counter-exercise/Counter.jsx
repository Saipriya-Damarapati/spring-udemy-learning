import { useState } from 'react';
import './Counter.css'
import CounterButton from './CounterButton';

export default function Counter() {

    const [count, setCount] = useState(0)

    function incrementParentCounterButton(by) {
        setCount(count + by)
    }

    function decrementParentCounterButton(by) {
        setCount(count - by)
    }

    function resetCounter() {
        setCount(0)
    }

    return (
        <div>
            <span className="count">{count}</span>
            <div>
                <CounterButton by={1} incrementMethod={incrementParentCounterButton} decrementMethod={decrementParentCounterButton} />
                <CounterButton by={2} incrementMethod={incrementParentCounterButton} decrementMethod={decrementParentCounterButton} />
                <CounterButton by={5} incrementMethod={incrementParentCounterButton} decrementMethod={decrementParentCounterButton} />
                <button className='resetButton' onClick={resetCounter}>Reset</button>
            </div>
        </div>
        
    )
}