import { VStack } from "@chakra-ui/react";
import { ColorModeButton } from "./components/ui/color-mode";
import Wrapper from "./components/Wrapper";

/*
 * Utilizei vite + Chakra UI para criar a interface
 * para os input's estou utilizando react hook form
 * 
 * A pasta components/ui são snippets gerados pelo chakra
 * 
 * Todas as requisições estão centralizadas na Pasta Services
 */
export default function App() {
    return (
        <VStack maxW={1024} padding={4} alignItems="flex-end" gap={4} mx="auto">
            <ColorModeButton />
            <Wrapper />
        </VStack>
    )
}