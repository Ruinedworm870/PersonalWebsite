import MainText, { MainTextProps } from "./MainText";

const GlitchText: React.FC<MainTextProps> = ({ children, color = "normal", size = 16, align = "left", style, bold = false }) =>
{
    return (
        <div
            className="glitchText"
        >
            <MainText
                color={color}
                size={size}
                align={align}
                bold={bold}
                style={style}
            >
                {children}
            </MainText>
        </div>
    )
}

export default GlitchText;