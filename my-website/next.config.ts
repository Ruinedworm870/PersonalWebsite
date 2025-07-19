import type { NextConfig } from "next";

const nextConfig: NextConfig = {
  /* config options here */
  eslint: {
    ignoreDuringBuilds: true
  },
};

module.exports = {
  output: 'standalone',
  eslint: {
    ignoreDuringBuilds: true
  }
};

export default nextConfig;
