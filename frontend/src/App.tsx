import { VStack } from "@chakra-ui/react";
import { ColorModeButton } from "./components/ui/color-mode";
import Wrapper from "./components/Wrapper";


export default function App() {
    return (
        <VStack maxW={1024} padding={4} alignItems="flex-end" gap={4} mx="auto">
            <ColorModeButton />
            <Wrapper />
        </VStack>
    )
}