import { Colors } from "@/hooks/Colors";

interface Props{
    
}

const ContentBackground: React.FC<Props> = () =>
{
    return (
        <>
            {/* Background layer */ }
            <div
                style={{
                    width: "85%",
                    margin: "auto",
                    top: 0,
                    left: 0,
                    right: 0,
                    bottom: 0,
                    position: "fixed",
                    backgroundColor: Colors.background,
                    zIndex: -1
                }}
            >

            </div>

            {/* Border layer */}
            <div
                style={{
                    width: "85%",
                    margin: "auto",
                    top: 0,
                    left: 0,
                    right: 0,
                    bottom: 0,
                    position: "fixed",
                    borderWidth: 1,
                    borderColor: Colors.primary,
                    borderStyle: "solid",
                    borderTop: "none",
                    pointerEvents: "none",
                    zIndex: 10,
                }}
            >

            </div>
        </>
    )
}

export default ContentBackground;