import { Button, DialogRootProvider, UseDialogReturn } from "@chakra-ui/react";
import { 
    DialogActionTrigger, 
    DialogCloseTrigger, 
    DialogContent, 
    DialogFooter, 
    DialogHeader,
    DialogTitle, 
} from "../ui/dialog";
import { useState } from "react";

type Props = {
    dialog: UseDialogReturn;
    callback: () => Promise<void>;
}
export default function DeleteDialog({dialog, callback}: Props) {
    const [disabled, setDisabled] = useState(false)

    const handle = async () => {
      setDisabled(true)
      await callback()
      setDisabled(false)
    }

    return (
        <DialogRootProvider value={dialog} >
        <DialogContent>
          <DialogHeader>
            <DialogTitle>Deseja deletar o usuario?</DialogTitle>
          </DialogHeader>
          <DialogFooter>
            <DialogActionTrigger asChild>
              <Button variant="outline">Cancel</Button>
            </DialogActionTrigger>
            <Button colorPalette="red" onClick={handle} disabled={disabled}>Confirmar</Button>
          </DialogFooter>
          <DialogCloseTrigger />
        </DialogContent>
    </DialogRootProvider>
    )
}