import { BrowserRouter,Routes,Route } from 'react-router-dom';
import './App.css';
import Home from './screens/home/home';
import DoctorDashboard from './screens/doctor/doctorDashboard';


function App() {
  return (
   <BrowserRouter>
      <Routes>
        <Route index element={<Home/>}></Route>
        <Route path='/home' element={<Home/>}></Route>
        <Route path='/home' element={<DoctorDashboard />}></Route>
      </Routes>
   </BrowserRouter>
  );
}

export default App;
