'use client'

import { Colors } from "@/hooks/Colors";
import MainText from "../text/MainText";
import Link from "next/link";
import { usePathname } from "next/navigation";

interface Props{

}

const TopBar: React.FC<Props> = () =>
{
    const pathname = usePathname();

    const buttons: {name: string, route: string}[] = [
        {
            name: "Home",
            route: "/"
        },
        {
            name: "About",
            route: "/about"
        },
        {
            name: "Projects",
            route: "/projects"
        },
        {
            name: "Contact",
            route: "/contact"
        } 
    ]
    
    const GetTextColor = (route: string): "normal" | "title" | "hover" =>
    {
        if (route === "/" && pathname === "/")
        {
            return "title";
        }
        else if (route !== "/" && pathname.startsWith(route))
        {
            return "title";
        }
        
        return "hover";
    }   
    
    return (
        <div
            style={{
                display: "flex",
                flexDirection: "row",
                alignItems: "center",
                justifyContent: "center",
                padding: "15px 0",
                borderWidth: 1,
                borderColor: Colors.primary,
                borderBottomStyle: "solid",
                backgroundColor: Colors.background,
                zIndex: 1,
                position: "sticky",
                top: 0
            }}
        >   
            {buttons.map((data, index) => (
                <Link
                    key={index}
                    href={data.route}
                    className="upOnHover"
                    style={{
                        textDecoration: "none"
                    }}
                >
                    <MainText
                        color={GetTextColor(data.route)}
                        size={24}
                        bold
                        style={{
                            padding: "0 15px"
                        }}
                    >
                        {data.name}
                    </MainText>
                </Link>
            ))}
        </div>
    )
}

export default TopBar;