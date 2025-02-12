
import { useForm, Controller } from "react-hook-form";
import { VStack,  Input, useDialog, Button } from "@chakra-ui/react";
import { NumberInputField,NumberInputRoot } from "../ui/number-input";
import { Field } from "../ui/field";
import SaveDialog from "../SaveDialog";
import { CreatePersonRequest } from "@/types/Person";
import { PersonService } from "@/services/PersonService";

const defaultValues: CreatePersonRequest = {
    age: 23,
    name: ""
}
export default function AddPersonForm() {
    const dialog = useDialog()

    const {handleSubmit, control, reset} = useForm<CreatePersonRequest>({
        defaultValues: defaultValues
    })

    const handler = async (data: CreatePersonRequest) => {
        await PersonService.save(data)
        reset(defaultValues)
        dialog.setOpen(false)
        
    }
    return(
        <>
            <Button onClick={() => dialog.setOpen(true)} variant="outline">
                Adicionar pessoa
            </Button>
            <SaveDialog 
                dialog={dialog}
                handler={handleSubmit(handler)}
            >
            <VStack gap={6}>
                <Field label="Nome">
                    <Controller 
                        name="name"
                        control={control}
                        render={({field: {onChange}}) => (
                            <Input 
                                placeholder="Nome"                                 
                                onChange={onChange}
                                
                            />
                        )}
                    />            
                </Field>
                <Field label="Idade">
                        <Controller 
                            name="age" 
                            control={control}
                            render={({field: {onChange, value}}) => (
                                <NumberInputRoot                             
                                    width="72px" 
                                    onChange={onChange}
                                    defaultValue={value.toString()}                                    
                                >
                                    <NumberInputField />
                                </NumberInputRoot>
                            )}
                        />
                    </Field>
                </VStack>
            </SaveDialog>
        </>
    );
}