import react from "react";
import { useParams } from 'react-router-dom';
import AuthenticateService from "./AuthenticateService";
import SideBar from "./SideBar";


function Welcome()
{
    const { username } = useParams();
  const myStyle={
    backgroundImage: 
"url('https://t3.ftcdn.net/jpg/05/02/18/64/360_F_502186443_Kubg3Wl76uE8BYl1tcAuYYXgGKAaO6r4.jpg')",
    height:'100vh',
    marginTop:'0px',
    backgroundSize: 'cover',
    backgroundRepeat: 'no-repeat',
};

const sidebarStyle={
    backgroundImage: 
"url('https://i.pinimg.com/236x/f4/7f/24/f47f24709105d4738edda3ebbfc9e35a.jpg')",
    height:'100vh',
    marginTop:'0px',
    backgroundSize: 'cover',
    backgroundRepeat: 'no-repeat',
};

   
     
    var handleOrder = ()=>{
      window.location = `/farmer-order/${username}`;
    }
    var handleProduct = ()=>{
        window.location = `/farmer-product`;
      }

    return(
        <div style={myStyle}>
            <SideBar/>
            
        </div>
 
    );
}

export default Welcome;