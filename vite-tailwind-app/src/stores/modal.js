import { defineStore } from "pinia";

export const useModalStore = defineStore("modal", {
    state: () => ({
        isOpen: false,
        title: "",
        msg: "",
        type: "",
        resolve: null,
    }),
    actions: {
        openA({ title, msg }) {
            this.title = title;
            this.msg = msg;
            this.type = "alert";
            this.isOpen = true;

            return new Promise((resolve) => {
                this.resolve = resolve;
            });
        },
        openB({ title, msg }) {
            this.title = title;
            this.msg = msg;
            this.type = "confirm";
            this.isOpen = true;

            return new Promise((resolve) => {
                this.resolve = resolve;
            });
        },
        ok() {
            this.isOpen = false;
            this.resolve?.(true);
            this._reset();
        },
        cancel() {
            this.isOpen = false;
            this.resolve?.(false);
            this._reset();
        },
        _reset() {
            this.title = "";
            this.msg = "";
            this.type = "";
            this.resolve = null;
        },
    },
});
