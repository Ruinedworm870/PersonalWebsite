'use client'

import { useEffect, useRef } from "react";

interface Props{

}

const MatrixRainCanvas: React.FC<Props> = () =>
{
    const canvasRef = useRef<HTMLCanvasElement>(null);
    const animationFrameId = useRef<number>(null); 
    const dropsRef = useRef<number[]>([]);

    const lastDrawTime = useRef<number>(0);
    const frameInterval = 1000 / 30; //30 fps
    
    const fontSize = 10;
    const letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    const SetupCanvas = () =>
    {
        const canvas = canvasRef.current;
        if (!canvas) return;
        
        const ctx = canvas.getContext('2d');
        if (!ctx) return;

        canvas.width = window.innerWidth;
        canvas.height = window.innerHeight;

        const columns = Math.floor(canvas.width / fontSize);
        dropsRef.current = Array.from({ length: columns }, () => Math.floor(Math.random() * canvas.height / fontSize));
    }
    
    const Draw = (timestamp: number) =>
    {        
        if (timestamp - lastDrawTime.current < frameInterval)
        {
            animationFrameId.current = requestAnimationFrame(Draw);
            return;
        }
        
        lastDrawTime.current = timestamp;

        const canvas = canvasRef.current;
        if (!canvas) return;
        
        const ctx = canvas.getContext('2d');
        if (!ctx) return;

        const { width, height } = canvas;
        
        ctx.fillStyle = 'rgba(3, 1, 4, 0.1)';
        ctx.fillRect(0, 0, width, height);

        dropsRef.current.forEach((drop, i) => {
            const text = letters[Math.floor(Math.random() * letters.length)];

            ctx.fillStyle = '#0f0';
            ctx.fillText(text, i * fontSize, drop * fontSize);

            if (drop * fontSize > height && Math.random() > 0.95)
            {
                dropsRef.current[i] = 0;
            }
            else
            {
                dropsRef.current[i] += 1;
            }
        })

        animationFrameId.current = requestAnimationFrame(Draw);
    }
    
    useEffect(() => {
       
        SetupCanvas();
        
        animationFrameId.current = requestAnimationFrame(Draw);//setInterval(Draw, 33);

        window.addEventListener('resize', SetupCanvas);

        return () => {
            //clearInterval(interval);
            if (animationFrameId.current)
            {
                cancelAnimationFrame(animationFrameId.current);
            }
            window.removeEventListener('resize', SetupCanvas);
        }

    }, []);
    
    return (
        <canvas
            ref={canvasRef}
            style={{
                position: "fixed",
                top: 0,
                left: 0,
                zIndex: -1,
                width: "100%",
                height: "100%"
            }}
        />
    )
}

export default MatrixRainCanvas;