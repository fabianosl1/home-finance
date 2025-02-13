import { useForm,Controller } from "react-hook-form";
import { CreateTransactionRequest } from "@/types/Transaction";

import SaveDialog from "../SaveDialog";
import { Field } from "../ui/field";
import { useTransaction } from "../hooks/useTransaction";
import { TransactionService } from "@/services/TransactionService";
import { SelectContent, SelectItem, SelectRoot, SelectTrigger, SelectValueText } from "../ui/select";
import { createListCollection, Input, VStack } from "@chakra-ui/react";
import { NumberInputField, NumberInputRoot } from "../ui/number-input";

const defaultValue: CreateTransactionRequest = {
    amount: 0,
    description: "",
    type: "INCOME"
}

const transactionsType = createListCollection({
    items: [
        {label: "Desepesa", value: "EXPENSE"},
        {label: "Receita", value: "INCOME"}
    ]
})

export default function AddTransactionForm() {
    const {dialog, personId} = useTransaction()
    
    const {handleSubmit, reset, control} = useForm<CreateTransactionRequest>({
        defaultValues: defaultValue
    })

    const handler = async (data: CreateTransactionRequest) => {
        if (!personId) {
            return;
        }

        await TransactionService.create(personId,data)
        reset(defaultValue)
        dialog.setOpen(false)
    }

    return(
        <>
            <SaveDialog callback={handleSubmit(handler)} dialog={dialog}>
                <VStack>
                    <Field label="Valor">
                    <Controller 
                        name="amount"
                        control={control}
                        render={({field: {onChange}}) => (                        
                            <NumberInputRoot
                                defaultValue="100"
                                onValueChange={({valueAsNumber}) => onChange(valueAsNumber)}
                                locale="pt-br"
                                formatOptions={{
                                    style: "currency",
                                    currency: "BRL",
                                    currencyDisplay: "code",
                                    currencySign: "standard"
                                }}
                            >
                                <NumberInputField />
                            </NumberInputRoot>
                        )}
                    />   
                    </Field>
                    <Field label="Descrição">
                        <Controller 
                            name="description"
                            control={control}
                            render={({field: {onChange}}) => (
                                <Input 
                                    placeholder="Descrição"                     
                                    onChange={onChange}
                                />
                            )}
                        />   
                    </Field>

                    <Field label="Tipo de transação">
                        <Controller
                            name="type"
                            control={control}
                            render={({field: {onChange}}) => (
                                <SelectRoot collection={transactionsType} onValueChange={e => onChange(e.value[0])}>
                                    <SelectTrigger>
                                        <SelectValueText placeholder="Transação" />
                                    </SelectTrigger>

                                    <SelectContent portalled={false} width="full">
                                        {transactionsType.items.map((item) => (
                                            <SelectItem item={item} key={item.value}>
                                            {item.label}
                                            </SelectItem>
                                        ))}
                                    </SelectContent>
                                </SelectRoot>
                            )}
                        />
                    </Field>
                </VStack>
            </SaveDialog>
        </>
    );
}