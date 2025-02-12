import { useForm } from "react-hook-form";
import { CreateTransactionRequest } from "@/types/Transaction";

const defaultValue: CreateTransactionRequest = {
    amount: 0,
    description: "",
    type: "INCOME"
}

export default function AddPersonForm() {
    const {handleSubmit, control, reset} = useForm<CreateTransactionRequest>({
        defaultValues: defaultValue
    })

    const handler = (data: CreateTransactionRequest) => {
        console.log(data)
        reset(defaultValue)        
    }

    return(
        <>
            
        </>
    );
}