import Tree from "./tree.vue";
import { action } from "@storybook/addon-actions";
export default {
  title: "Functional/[PIFC] Tree",
  component: Tree,
  decorators: [
    () => ({
      template: `
        <div style="margin: 1em;">
          <h2 style="margin-bottom: 20px; font-size: 20px; color: #212121;">(예시) TREE </h2>
          <a href="https://github.com/zdy1988/vue-jstree" target="_blank">* 참고 링크 *</a>
          <div style="display: flex; flex-direction: row; ">
            <story />
           </div>
        </div>`
    })
  ],
  args: {
    data: [
      {
        text: "Same but with checkboxes",
        children: [
          {
            text: "initially selected",
            selected: false
          },
          {
            text: "custom icon",
            icon: "fa fa-warning icon-state-danger"
          },
          {
            text: "initially open",
            icon: "fa fa-folder icon-state-default",
            opened: true,
            children: [
              {
                text: "Another node"
              }
            ]
          },
          {
            text: "custom icon",
            icon: "fa fa-warning icon-state-warning"
          },
          {
            text: "disabled node",
            icon: "fa fa-check icon-state-success",
            disabled: true
          }
        ]
      },
      {
        text: "Same but with checkboxes",
        opened: true,
        children: [
          {
            text: "initially selected",
            selected: true
          },
          {
            text: "custom icon",
            icon: "fa fa-warning icon-state-danger"
          },
          {
            text: "initially open",
            icon: "fa fa-folder icon-state-default",
            opened: true,
            children: [
              {
                text: "Another node"
              }
            ]
          },
          {
            text: "custom icon",
            icon: "fa fa-warning icon-state-warning"
          },
          {
            text: "disabled node",
            icon: "fa fa-check icon-state-success",
            disabled: true
          }
        ]
      },
      {
        text: "And wholerow selection"
      },
      {
        text: "drag disabled",
        icon: "fa fa-warning icon-state-danger",
        dragDisabled: true
      },
      {
        text: "drop disabled",
        icon: "fa fa-warning icon-state-danger",
        dropDisabled: true
      }
    ],
    size: "",
    showCheckbox: false,
    wholeRow: false,
    noDots: false,
    collapse: false,
    multiple: false,
    allowBatch: false,
    partialBatch: false,
    allowTransition: true,
    textFieldName: "text",
    valueFieldName: "value",
    childrenFieldName: "children",
    itemEvents: {},
    async: null,
    loadingText: "Loading...",
    draggable: false,
    dragOverBackgroundColor: "#C9FDC9"
  },
  argTypes: {
    data: { type: "array", description: "트리 데이터" },
    size: {
      type: "string",
      description: "트리 항목 크기 설정, 값 : 'large' or '' or 'small'"
    },
    showCheckbox: { type: "boolean", description: "체크박스 사용" },
    allowTransition: {
      type: "boolean",
      description: "트리 열고 닫을때 애니메이션 사용"
    },
    wholeRow: {
      type: "boolean",
      description: "전체 행 상태 사용(selected, hovered 영역)"
    },
    noDots: {
      type: "boolean",
      description: "점 표시 또는 숨기기(트리 depth 라인)"
    },
    collapse: {
      type: "boolean",
      description: "모든 트리 항목 축소 상태 설정"
    },
    multiple: {
      type: "boolean",
      description: "여러개 트리 항목 선택 가능"
    },
    allowBatch: {
      type: "boolean",
      description: "여러개 선택해서 배치 선택 허용(부모 선택 > 하위 모두 선택 / 하위 모두 선택 > 부모선택)"
    },
    partialBatch: { type: "boolean", description: "부분선택 기능" },
    textFieldName: {
      type: "string",
      description: "Display field"
    },
    valueFieldName: {
      type: "string",
      description: "Value field"
    },
    childrenFieldName: {
      type: "string",
      description: "Children field"
    },
    itemEvents: {
      type: "object",
      description: "트리 항목에 이벤트 등록"
    },
    async: {
      type: "func",
      description: "비동기 로드 콜백 함수, 노드가 리프인 경우 데이터에서 'isLeaf: true'를 설정할 수 있습니다."
    },
    loadingText: { type: "string", description: ":Loading text" },
    draggable: {
      type: "boolean",
      description:
        "트리 항목 설정을 끌 수 있으며, 선택적 끌어서 놓기를 통해 'dragDisabled: true' 및 'dropDisabled: true'를 설정할 수 있습니다. 모든 기본값은 'false'입니다."
    },
    dragOverBackgroundColor: {
      control: "color",
      description: "Drag over background color"
    }
  }
};

export const Default = (args, { argTypes }) => {
  return {
    components: { Tree },
    template: `<tree :data="data"
                     :size="size"
                     :show-checkbox="showCheckbox"
                     :whole-row="wholeRow"
                     :no-dots="noDots"
                     :collapse="collapse"
                     :multiple="multiple"
                     :allow-batch="allowBatch"
                     :partial-batch="partialBatch"
                     :allow-transition="allowTransition"
                     :text-field-name="textFieldName"
                     :value-field-name="valueFieldName"
                     :children-field-name="childrenFieldName"
                     :item-events="itemEvents"
                     :async="async"
                     :loading-text="loadingText"
                     :draggable="draggable"
                     :drag-over-background-color="dragOverBackgroundColor"
                     :klass="klass"
                     @item-click="itemClick"
                     @item-toggle="itemToggle"
                     @item-drag-start="itemDragStart"
                     @item-drag-end="itemDragEnd"
                     @item-drop-before="itemDropBefore"
                     @item-drop="itemDrop"
                     ref="tree">
                    <!-- custom -->
<!--                    <template v-slot="_">-->
<!--                    <span v-html="_.model[textFieldName]"></span>-->
<!--                    </template>-->
    </tree>`,
    computed: {
      data() {
        return args.data;
      },
      size() {
        return args.size;
      },
      showCheckbox() {
        return args.showCheckbox;
      },
      wholeRow() {
        return args.wholeRow;
      },
      noDots() {
        return args.noDots;
      },
      collapse() {
        return args.collapse;
      },
      multiple() {
        return args.multiple;
      },
      allowBatch() {
        return args.allowBatch;
      },
      partialBatch() {
        return args.partialBatch;
      },
      allowTransition() {
        return args.allowTransition;
      },
      textFieldName() {
        return args.textFieldName;
      },
      valueFieldName() {
        return args.valueFieldName;
      },
      childrenFieldName() {
        return args.childrenFieldName;
      },
      itemEvents() {
        return args.itemEvents;
      },
      async() {
        return args.async;
      },
      loadingText() {
        return args.loadingText;
      },
      draggable() {
        return args.draggable;
      },
      dragOverBackgroundColor() {
        return args.dragOverBackgroundColor;
      },
      klass() {
        return args.klass;
      }
    },
    methods: {
      itemClick(node, item, e) {
        action("item-click")(item);
      },
      itemToggle(node, item, e) {
        action("item-toggle")(item);
      },
      itemDragStart(node, item, e) {
        action("item-drag-start")(item);
      },
      itemDragEnd(node, item, e) {
        action("item-drag-end")(item);
      },
      itemDropBefore(node, item, draggedItem, e) {
        action("item-drop-before")(item);
      },
      itemDrop(node, item, draggedItem, e) {
        action("item-drop")(item);
      }
    }
  };
};
