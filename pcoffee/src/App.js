import logo from './logo.svg';
import './App.css';
import { useState } from 'react';
import {Link} from "./Component/Link";
import { Button } from './Component/Button';

const names = ['chintan','nishtha','mohit','lavish'];
const heading  = "Welcome to pragra app";

const newNameGenerator =() =>`${names[0]} added as string`;

function App() {
  function getNameAsList(){
    return names.map((name)=> <li>{name}</li>);
  }
  const [count, setCount] = useState(0);
  return (
    <div>
      <div className='container'>
        <div className='counter'>{heading}</div>
          <div className='btn-grp'>
              <button onClick={()=>setCount(count+1)} className='btn'>Increment Counter   {count}</button>
              <button onClick={()=>setCount(count-1)} className='btn'>Decrement Counter   {count}</button>
          </div>
      </div>
      <Link href="/customer" linkText="click here for details"></Link>
      <br></br>
      <Button 
        btnText={"Click here to see action"}
        action={()=> alert("Hello world")}
      /> 
      <div>
            <ul>{getNameAsList()}</ul>
            <li>{newNameGenerator()}</li>
      </div>
    </div>
    
  );
}

export default App;
