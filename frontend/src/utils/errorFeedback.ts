import { toaster } from "@/components/ui/toaster"
import { ApiException } from "@/exceptions/ApiException"

type Types = "success" | "info" | "warning" | "error"

export async function errorFeedback(fun: () => Promise<void>, toast?: {title: string, type: Types}) {
        try {
            await fun()
            if (toast) {
            toaster.create({
                title: toast.title,
                type: toast.type
            })
        }
        } catch (err) {
            if (err instanceof ApiException) {
                for (const message of err.messages) {
                    toaster.create({
                        title: message,
                        type: "warning"
                    })
                }
            } else {            
                toaster.create({
                    title: "Acho que estamos com problemas",
                    type: "error"
                })
            }
        } 
}