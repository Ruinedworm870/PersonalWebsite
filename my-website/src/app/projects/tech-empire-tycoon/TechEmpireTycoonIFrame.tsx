'use client'

import { useEffect, useState } from "react";

interface Props{

}

const TechEmpireTycoonIFrame: React.FC<Props> = () =>
{
    const [showIFrame, setShowIFrame] = useState(false);
    
    useEffect(() => {
        setShowIFrame(true);
    }, []);
    
    return (
        <>
            {showIFrame &&
                <iframe
                    style={{
                        zIndex: 1,
                        position: "relative",
                        border: 0
                    }}
                    src="https://itch.io/embed/3725520?bg_color=030104&amp;fg_color=ffffff&amp;link_color=70e43a&amp;border_color=70e43a"
                    width="552"
                    height="167"
                >
                    <a href="https://william-smolinski-jr.itch.io/tech-empire-tycoon">Tech Empire Tycoon by William Smolinski Jr</a>
                </iframe>
            }   
        </>    
    )
}

export default TechEmpireTycoonIFrame;