import {CircleUserRound} from "lucide-react";
import {useAtom} from "jotai";
import {userAtom} from "../../atoms/User.js";
import {sidebarAtom} from "../../atoms/Sidebar.js";

export const UserButton = () => {
    const [isOpen, setIsOpen] = useAtom(userAtom);
    const [isSidebarOpen, setIsSidebarOpen] = useAtom(sidebarAtom);

    const handleToggleUserMenu = () => {
        if(isOpen) setIsOpen(false);
        else {
            setIsOpen(true);
            setIsSidebarOpen(false);
        }
    }

    return (
        <button className="cursor-pointer ml-auto" onClick={handleToggleUserMenu}>
            <CircleUserRound color="white" size={42}/>
        </button>
    )
}

export default UserButton;