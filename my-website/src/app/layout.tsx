import ContentBackground from "@/components/background/ContentBackground";
import MatrixRainCanvas from "@/components/background/MatrixRainCanvas";
import TopBar from "@/components/navigation/TopBar";
import { Colors } from "@/hooks/Colors";
import type { Metadata } from "next";

import "@/styles/style.css";
import "@/styles/hover.css";
import "@/styles/text.css";

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
					backgroundColor: Colors.background
				}}
			>
				<MatrixRainCanvas />
				<ContentBackground>
					<TopBar />
					{children}
				</ContentBackground>
			</body>
		</html>
	);
}
