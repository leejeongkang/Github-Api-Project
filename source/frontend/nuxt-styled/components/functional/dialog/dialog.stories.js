import Dialog from "./dialog.vue";
import { action } from "@storybook/addon-actions";

export default {
  title: "Functional/[PCFI] 모달 - 다이얼로그",
  component: Dialog,
  decorators: [
    () => ({
      template: `
        <div style="margin: 1em;">
          <h2 style="margin-bottom: 20px; font-size: 20px; color: #212121;">(예시) Modal </h2>
          <div style="display: flex; flex-direction: row; ">
            <story />
          </div>
         </div>
        `
    })
  ],
  args: {
    title: "제목 입니다",
    width: "600px",
    height: "250px",
    dialogName: "dialog-default"
  },
  argTypes: {
    title: {
      type: "string",
      description: "모달 창의 제목입니다."
    },
    width: {
      type: "string",
      description: "모달 창의 너비입니다."
    },
    height: {
      type: "string",
      description: "모달 창의 높이입니다."
    },
    dialogName: {
      type: "string",
      description: "모달 창의 이름입니다.",
      require: true
    }
  },
  parameters: {
    docs: {
      source: {
        code: `
          <Dialog
            @close="onClose"
            @confirm="onConfirm"
            @open="onOpen"
            :dialog-name="'dialog'"
            :title="title"
            :opened="true"
          >
          <div slot="body"> 본문 코드 </div>
        </Dialog>
        `
      },
      iframeHeight: 300
    }
  }
};

export const Default = (args, { argTypes }) => {
  return {
    components: { Dialog },
    template: `
      <div>
        <Dialog
          @close="onClose"
          @confirm="onConfirm"
          @open="onOpen"
          :dialog-name="dialogName"
          :title="title"
          :width="width"
          :height="height"
        >
          <div slot="body" class="modal__body modal__body--sm">모달은 이렇게 생겼습니다.</div>
        </Dialog>
        <button class="button button--tertiary" @click="showModal"> <span class="button__text">Dialog Modal Example</span> </button>
      </div>
    `,
    computed: {
      title() {
        return args.title;
      },
      width() {
        return args.width;
      },
      height() {
        return args.height;
      },
      dialogName() {
        return args.dialogName;
      }
    },
    methods: {
      onClose(p) {
        action("close")(p);
      },
      onConfirm(p) {
        action("confirm")(p);
      },
      onOpen(p) {
        action("open")(p);
      },
      showModal() {
        this.$modal.show(this.dialogName);
      }
    }
  };
};
