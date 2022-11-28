import Alert from "./alert-default.vue";
import {action} from "@storybook/addon-actions";

export default {
  title: 'Functional/[PCFI] 모달 - 얼럿',
  component: Alert,
  decorators: [
    () => ({
      template: `
        <div style="margin: 1rem;">
            <h2 style="margin-bottom: 20px; font-size: 20px; color: #212121;">(예시) Alert </h2>
            <div style="display: flex; flex-direction: row; ">
                <story />
            </div>
        </div>
        `
    }),
  ],
  args: {
    alertText: "제목 입니다",
    width: "600px",
    height: "auto",
    type: "default"
  },
  argTypes: {
    title: {
      type: "string",
      description: "Alert 창의 제목입니다."
    },
    content: {
      type: "string",
      description: "Alert 창의 본문 입니다. HTML 코드도 허용 됩니다."
    },
    iconTheme: {
      type: "string",
      description: "Alert 아이콘의 색상 테마를 지정 합니다.",
      control: {
        type: "select",
        options: ["info", "warning", "error", "success"]
      }
    },
    cancelButtonTheme: {
      type: "string",
      description: "Alert 취소 버튼의 색상 테마를 지정 합니다.",
      control: {
        type: "select",
        options: ["primary", "secondary", "tertiary", "support", "negative", "danger", "link"]
      }
    },
    confirmButtonTheme: {
      type: "string",
      description: "Alert 기본 버튼의 색상 테마를 지정 합니다.",
      control: {
        type: "select",
        options: ["primary", "secondary", "tertiary", "support", "negative", "danger", "link"]
      }
    },
    confirmButtonText: {
      type: "string",
      description: "Alert 기본 버튼의 텍스트를 지정 합니다."
    },
    cancelButtonText: {
      type: "string",
      description: "Alert 취소 버튼의 텍스트를 지정 합니다."
    },
    type: {
      type: "string",
      description: "Alert 타입을 결정 합니다.",
      control: {
        type: "radio",
        options: ["default", "confirm"]
      }
    }
  },
  parameters: {
    docs: {
      source: {
        code: `<Alert
            @close="onClose"
            @confirm="onConfirm"
            :dialog-name="'alert'"
            :title="title"
            :opened="true"
            >
            </Alert>`
      },
      iframeHeight: 300
    }
  }
};

export const Default = (args, {argTypes}) => {
  return {
    components: {Alert},
    template: `
      <div>
      <button @click="onModal" class="button button--tertiary"><span class="button__text">Alert Modal Example </span>
      </button>
      </div>
    `,
    computed: {
      title() {
        return args.title;
      },
      content() {
        return args.content;
      },
      iconTheme() {
        return args.iconTheme;
      },
      cancelButtonTheme() {
        return args.cancelButtonTheme;
      },
      confirmButtonTheme() {
        return args.confirmButtonTheme;
      },
      confirmButtonText() {
        return args.confirmButtonText;
      },
      cancelButtonText() {
        return args.cancelButtonText;
      },
      type() {
        return args.type;
      }
    },
    methods: {
      onClose(p) {
        action("close")(p);
      },
      onModal() {
        this.$modal.show(Alert, {alertText: "얼럿은 이렇게 생겼습니다."});
      }
    }
  };
};
