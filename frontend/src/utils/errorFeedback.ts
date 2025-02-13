import { toaster } from "@/components/ui/toaster"
import { ApiException } from "@/exceptions/ApiException"

type Types = "success" | "info" | "warning" | "error"

export async function errorFeedback(title: string, type: Types, fun: () => Promise<void>) {
        try {
            await fun()
            toaster.create({
                title: title,
                type: type
            })
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