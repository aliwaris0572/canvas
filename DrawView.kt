package com.example.myapplication

import android.content.Context
import android.util.AttributeSet
import android.view.View
import kotlin.math.cos
import kotlin.math.sin
import android.graphics.*



class DrawView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private var mPaint = Paint()
    private var mTextPaint = Paint()
    private var mNodes : MutableMap<String, Node> = HashMap()
    private lateinit var mCurrentNode: Node

    var cx = 200f
    var cy = 800f
    var angle = 0f
    var dx = 0f

    init {
        mPaint.apply {
            color = Color.GRAY
            style = Paint.Style.STROKE
            strokeJoin = Paint.Join.ROUND
            strokeCap = Paint.Cap.ROUND
            strokeWidth = 12f
            isAntiAlias = true
        }

        mTextPaint.apply {
            color = Color.MAGENTA
            textSize = 36f
            strokeWidth = 1f
            isAntiAlias = true
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        for(node in mNodes) {
            if(node.value.destinationNode == null) {
                canvas.save()
                canvas.rotate(node.value.angle, node.value.x, node.value.y)
                canvas.drawLine(node.value.x, node.value.y, node.value.x + node.value.length, node.value.y, mPaint)
                canvas.restore()
            } else {
                canvas.save()
                canvas.drawLine(node.value.x, node.value.y, node.value.destinationNode.x, node.value.destinationNode.y, mPaint)
                canvas.restore()
            }
            canvas.drawText(node.key, node.value.x+10, node.value.y-10, mTextPaint)
        }
    }

    fun addLine(tiltAngle: Float, length: Float, nodeName:String) {
        angle = tiltAngle
        dx = length

        mCurrentNode = Node(tiltAngle, length, cx, cy)
        mNodes[nodeName] = mCurrentNode

        // finding end co-ordinates of line segment
        cx = (cx + dx * cos(Math.toRadians(angle.toDouble()))).toFloat()
        cy = (cy + dx * sin(Math.toRadians(angle.toDouble()))).toFloat()
    }

    fun enclose(fromNode: String, toNode: String) {
        mCurrentNode = Node(cx, cy, mNodes[toNode])
        mNodes[fromNode] = mCurrentNode;

        cx = mNodes[toNode]?.x ?: 0f
        cy = mNodes[toNode]?.y ?: 0f

    }

    fun draw(){
        invalidate()
    }

}