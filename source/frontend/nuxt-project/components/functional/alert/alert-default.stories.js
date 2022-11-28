import Alert from "./alert-default.vue";
import { action } from "@storybook/addon-actions";

export default {
  title: 'Functional/[PCFI] 얼럿 모달',
  component: Alert,
  decorators: [
    () => ({
      template:
        '<div style="margin: 1em;"><h2 style="margin-bottom: 20px; font-size: 20px; color: #212121;">(예시) 얼럿 모달 </h2><div style="display: flex; flex-direction: row; "><story /></div></div>',
    }),
  ],
  args: {
    title: "제목 입니다",
    content: "<b>강조표시</b>원투쓰리포파이브씩수",
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
        code: '<Alert @close="onClose"/>'
      },
      iframeHeight: 300
    }
  }
};

export const Default = (args, { argTypes }) => {
  return {
    components: { Alert },
    template: `
      <div>
        <Alert
          @close="onClose"
          :title="title"
          :content="content"
          :icon-theme="iconTheme"
          :confirm-button-theme="confirmButtonTheme"
          :cancel-button-theme="cancelButtonTheme"
          :confirm-button-text="confirmButtonText"
          :cancel-button-text="cancelButtonText"
          :type="type"/>
        <br/><br/><br/><br/><br/><br/><br/><br/><br/>
        <button @click="onModal"> Modal Example </button>
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
        this.$modal.show(Alert, { title: "모달 테스트", content: "테테테" });
      }
    }
  };
};
