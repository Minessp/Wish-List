import Logo from "./assets/logo/logo.png";
import HomeSubtitle from "./components/HomeText/HomeSubtitle.jsx";
import HomeTitle from "./components/HomeText/HomeTitle.jsx";
import WishListContainer from "./components/WishList/WishListContainer.jsx";
import BackgroundAnimation from "./components/BackgroundAnimation.jsx";
import SidebarMenuButton from "./components/Sidebar/SidebarMenuButton.jsx";
import SidebarMenu from "./components/Sidebar/SidebarMenu.jsx";
import UserButton from "./components/User/UserButton.jsx";
import {useAtom} from "jotai";
import {sidebarAtom} from "./atoms/Sidebar.js";
import {userAtom} from "./atoms/User.js";
import UserMenu from "./components/User/UserMenu.jsx";

function App() {
    const [isOpen, setIsOpen] = useAtom(sidebarAtom);
    const [isUserOpen, setIsUserOpen] = useAtom(userAtom);

    return(
        <div className={`flex w-screen min-h-screen bg-linear-to-r from-bg-start to-bg-end to-25% ${isOpen ? 
        "px-0 pr-5 pb-0" : "px-5 pb-5"}`}>
            <SidebarMenu />
            <main className="w-full">
                <header className="w-full flex items-center md:pr-6 md:pl-3 py-4 relative z-50">
                    <SidebarMenuButton />
                    <a className="mr-3 min-w-max" href="/">
                        <img className="h-8" src={Logo} alt="Logo" />
                    </a>
                    <UserButton />
                    {isUserOpen ? <UserMenu /> : null}
                </header>

                <div className="flex flex-col items-center text-center p-6 font-outfit text-white relative z-10">
                    <HomeTitle />
                    <HomeSubtitle/>
                </div>

                <WishListContainer />
                {/*Safe Highlights ideia - deixar a animação apenas no momento de criação da wishlist*/}
                <BackgroundAnimation />
            </main>
        </div>
    );
}

export default App;
