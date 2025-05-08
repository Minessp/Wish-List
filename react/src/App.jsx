import './App.css'
import Logo from "./assets/logo/logo.png";
import HomeSubtitle from "./components/HomeSubtitle.jsx";
import HomeTitle from "./components/HomeTitle.jsx";
import {CircleUserRound, Menu} from "lucide-react";
import WishListContainer from "./components/WishListContainer.jsx";

function App() {
    return(
        <div className="w-screen h-screen bg-linear-to-r from-bg-start
         to-bg-end to-25%">
            <header className="w-full flex items-center px-6 py-4">
                <Menu strokeWidth={3} color="white" size={40}/>
                <a href="/">
                    <img className="h-10" src={Logo} alt="Logo" />
                </a>
                <CircleUserRound className="ml-auto" color="white" size={45}/>

            </header>

            <div className="flex flex-col items-center p-6 font-outfit text-white">
                <HomeTitle />
                <HomeSubtitle/>
            </div>

            <WishListContainer />

        </div>
    );
}

export default App;
