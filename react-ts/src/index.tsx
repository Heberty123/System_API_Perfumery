import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import Header from './layout/header/index'
import Main from './layout/main'


const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <>
    <Header/>
    <Main/>
  </>
);


