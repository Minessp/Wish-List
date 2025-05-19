import {useAtom} from "jotai";
import {userAtom} from "../../atoms/User.js";
import {UserMenuLinks} from "../../data/UserMenuLinks.jsx";

export const UserMenu = () => {
    const [isOpen, setIsOpen] = useAtom(userAtom)

    return (
        <div className="bg-[#5c8edc] border-2 border-sky-500 w-[150px] h-[150px] fixed right-11 top-18
        rounded-2xl z-51">
            <ul className="w-full text-gray-900 font-outfit font-medium relative flex flex-col
            mt-4 mb-4 text-center items-center gap-1">
                {UserMenuLinks.map((link, index) => (
                    <li key={index}>
                        <a className={link.style} href={link.path}>{link.name}</a>
                    </li>
                ))}
            </ul>
        </div>
    )
}

export default UserMenu;