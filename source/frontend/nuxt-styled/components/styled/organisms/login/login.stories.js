import Login from "./login.vue";
import { action } from "@storybook/addon-actions";

export default {
  title: 'Styled/Organisms/[PCFC] 로그인',
  component: Login,
  parameters: {
    docs: {
      source: {
        code: '<Login @login="onLogin"/>',
      },
    },
  },
};

const Template = (args, { argTypes }) => ({
  components: { Login },
  template: '<Login @login="onLogin"/>',
  methods: {
    onLogin(p) {
      action("login")(p);
    },
  },
});

export const Default = Template.bind({});
