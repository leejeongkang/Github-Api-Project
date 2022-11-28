
import GroupBreadcrumb from './group-breadcrumb.vue';
import { action } from "@storybook/addon-actions";

export default {
  title: 'Styled/Molecules/[PCFI] 브레드크럼',
  components: GroupBreadcrumb,
  decorators: [
    () => ({
      template:
        '<div style="margin: 1em;"><h2 style="margin-bottom: 40px; font-size: 20px; color: #212121;">(예시) Breadcrumb </h2><story /></div>',
    }),
  ],
};

export const Default = () => ({
  components: { GroupBreadcrumb },
  template: '<GroupBreadcrumb @select="onSelect"></GroupBreadcrumb>',
  methods: {
    onSelect(item) {
      action("select")(item);
    }
  }
});
