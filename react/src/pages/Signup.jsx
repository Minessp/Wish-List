import Logo from "../assets/logo/logo.png";

export const Signup = () => {
    return (
        <div className="w-screen h-screen bg-linear-to-r from-bg-start to-bg-end to-25%">
            <header className="flex items-center px-6 py-4">
                <a href="/">
                    <img className="h-8" src={Logo} alt="Logo" />
                </a>
            </header>
            <div className="flex flex-col items-center justify-center flex-grow px-4">
                <h1 className="text-2xl font-semibold mb-6 text-center text-white">
                    Todos seus desejos em um só lugar
                </h1>
            </div>

            <form className="w-full max-w-md bg-white p-6 rounded-xl">
            </form>
        </div>
    )
}

export default Signup;