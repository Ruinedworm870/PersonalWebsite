import ContentBackground from "@/components/background/ContentBackground";
import MatrixRainCanvas from "@/components/background/MatrixRainCanvas";
import TopBar from "@/components/navigation/TopBar";
import { Colors } from "@/hooks/Colors";
import type { Metadata } from "next";

import "@/styles/style.css";
import "@/styles/hover.css";
import "@/styles/text.css";
import "@/styles/box.css"

export const metadata: Metadata = {
	title: "William Smolinski Jr",
	description: "Portfolio site for William Smolinski Jr",
};

export default function RootLayout({ children }: Readonly<{ children: React.ReactNode; }>)
{
	return (
		<html lang="en">
			<body
				className={`antialiased`}
				style={{
					backgroundColor: Colors.background,
					margin: 0
				}}
			>
				<MatrixRainCanvas />
				<ContentBackground />
				
				<div style={{
					width: "85%",
					margin: "auto"
				}}>
					<TopBar />
					{children}
				</div>
			</body>
		</html>
	);
}
