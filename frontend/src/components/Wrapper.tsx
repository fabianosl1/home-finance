import { Tabs } from "@chakra-ui/react";
import Person from "./person/Person";
import Transaction from "./transaction/Transaction";

export default function Wrapper() {

    return (
      <>
        <Tabs.Root width="full" defaultValue="persons">
            <Tabs.List>
                <Tabs.Trigger value="persons">
                    Pessoas
                </Tabs.Trigger>
                <Tabs.Trigger value="transactions">
                    Transações
                </Tabs.Trigger>
            </Tabs.List>
            <Tabs.Content value="persons">
                <Person/>
            </Tabs.Content>
            <Tabs.Content value="transactions">
                <Transaction />
            </Tabs.Content>
        </Tabs.Root>
      </>
    )
}