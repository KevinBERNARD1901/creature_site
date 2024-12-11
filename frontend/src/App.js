import './App.css';
import Horodateur from './Pages/Horodateur';
import To_do from './Pages/To_do';
import Agenda from './Pages/Agenda';
import Creatures from './Pages/Creatures';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';

const router = createBrowserRouter([
  {
    path: '/',
    element: <Horodateur />
  },
  {
    path: '/to_do',
    element: <To_do />
  },
  {
    path: '/agenda',
    element: <Agenda />
  },
  {
    path: '/creatures',
    element: <Creatures />
  } 
]);

function App() {
  return (
    <RouterProvider router={router} />
  );
}

export default App;
