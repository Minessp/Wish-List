import {Menu, X} from "lucide-react";
import {sidebarAtom} from "../../atoms/Sidebar.js"
import {useAtom} from "jotai";
import {userAtom} from "../../atoms/User.js";

export const SidebarMenuButton = () => {
    const [isOpen, setIsOpen] = useAtom(sidebarAtom);
    const [isUserOpen, setIsUserOpen] = useAtom(userAtom);

    return (
        <button className="cursor-pointer" onClick={() => {setIsOpen(true); setIsUserOpen(false)}}>
            {isOpen ? null : <Menu className="mr-3" strokeWidth={3} color="white" size={35}/>}
        </button>
    )
}

export default SidebarMenuButton;