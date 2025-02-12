import { CreatePersonRequest } from "@/types/Person";
import { useForm, Controller } from "react-hook-form";
import CreateDialog from "../AddDialog";
import { VStack,  Input, NumberInputRoot } from "@chakra-ui/react";
import { NumberInputField } from "../ui/number-input";
import { Field } from "../ui/field";
import { PersonService } from "@/services/PersonService";

export default function AddPersonForm() {
    const {handleSubmit, control, reset} = useForm<CreatePersonRequest>({
        defaultValues: {
            age:13,
            name: ""
        }
    })

    const handler = (data: CreatePersonRequest) => {
        PersonService.save(data)
        .then(() => reset({
            age:13,
            name: ""
        }))
    }
    return(
        <>
            <CreateDialog 
                handler={handleSubmit(handler)} 
                buttonText="Adicionar pessoa" 
                title="Pessoa"
            >
            <VStack gap={6}>
                <Field label="Nome">
                    <Controller 
                        name="name"
                        control={control}
                        render={({field: {onChange, onBlur, value}}) => (
                            <Input 
                                placeholder="Nome" 
                                value={value} 
                                onChange={onChange}
                                onBlur={onBlur}
                            />
                        )}
                    />            
                </Field>
                <Field label="Idade">
                        <Controller 
                            name="age" 
                            control={control}
                            render={({field: {onChange, onBlur, value}}) => (
                                <NumberInputRoot                             
                                    width="72px" 
                                    onChange={onChange}
                                    onBlur={onBlur}
                                    value={value.toString()}
                                >
                                    <NumberInputField />
                                </NumberInputRoot>
                            )}
                        />
                    </Field>
                </VStack>
            </CreateDialog>
        </>
    );
}